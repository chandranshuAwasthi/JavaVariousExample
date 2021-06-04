package com.chan.newFeature;

import java.util.HashMap;
import java.util.Map;

class FrameNotSupportedException extends Exception {
    public FrameNotSupportedException(String message) {
        super(message);

    }
    public FrameNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}

 abstract class SumCalculator{
    private int numberOFFrames;
    private int[] commaseperatedScores;


     public int getNumberOFFrames() {
         return numberOFFrames;
     }

     public int[] getCommaseperatedScores() {
         return commaseperatedScores;
     }

     public void setCommaseperatedScores(int[] commaseperatedScores) {
         this.commaseperatedScores = commaseperatedScores;
     }

     public void setNumberOFFrames(int numberOFFrames) {

         this.numberOFFrames = numberOFFrames;
     }

     public SumCalculator(int numberOFFrames, int[] commaseperatedScores) {
        this.numberOFFrames = numberOFFrames;

        this.commaseperatedScores = commaseperatedScores;
    }

    public abstract int calculateScores() throws FrameNotSupportedException ;
         //char[] array = commaseperatedScores.toCharArray();




}



public class FrameSumCalculator extends SumCalculator {
    //private int numberOFFrames;
    //private int[] commaseperatedScores;

    public FrameSumCalculator(int numberOFFrames, int[] commaseperatedScores) {
        super(numberOFFrames,commaseperatedScores);
        //this.numberOFFrames = numberOFFrames;
        //this.commaseperatedScores = commaseperatedScores;
    }

    private int creationOfFrames(int[] array) throws FrameNotSupportedException {
        Map<Integer, Integer> mapOfFrames = new HashMap<>();
        // int count;
        int indextoCalculate = 0;
        try {
            for (int i = 1; i <= this.getNumberOFFrames() - 1; i++) {
                int count = 1;
                while (count <= 2) {
                    String strValue = String.valueOf(array[indextoCalculate]);
                    //Strike
                    if (count != 2 && "10".equalsIgnoreCase(strValue)) {
                        Integer scoreforStrike = Integer.valueOf(strValue) + Integer.valueOf(array[indextoCalculate + 1]) + Integer.valueOf(array[indextoCalculate + 2]);
                        mapOfFrames.put(i, scoreforStrike);
                        count = 0;
                        indextoCalculate++;
                        break;

                    } else {
                        if (mapOfFrames.containsKey(i)) {
                            Integer ScoreForSpare = Integer.valueOf(mapOfFrames.get(i)) + Integer.valueOf(array[indextoCalculate]);
                            if (ScoreForSpare > 10) {
                                throw new FrameNotSupportedException("Frame sum can not be more than 10");
                            }
                            if (ScoreForSpare == 10) {
                                ScoreForSpare = ScoreForSpare + Integer.valueOf(String.valueOf(array[indextoCalculate + 1]));
                            }
                            mapOfFrames.put(i, ScoreForSpare);
                            count++;
                            //   break;
                        } else {
                            mapOfFrames.put(i, Integer.valueOf(strValue));
                            count++;
                        }
                        indextoCalculate++;
                    }

                }
            }

        } catch (ArrayIndexOutOfBoundsException aibe) {
            throw new FrameNotSupportedException("Frames Are not as expected");
        }
        System.out.println("score " + mapOfFrames);
        calculationOfLastFrame(mapOfFrames, indextoCalculate, array);
        int score = ScoreCalculationForFrames(mapOfFrames);
        System.out.println("score " + mapOfFrames);
        return score;
    }

    private int ScoreCalculationForFrames(Map<Integer, Integer> mapOfFrames) {
       /* final int i=0;
        mapOfFrames.forEach((k,v)->{
            i+=v;
        });
*/
//        IntSummaryStatistics n=mapOfFrames.entrySet().stream().collect(Map.Entry<Integer,Integer>::getValue);

        //      int sum = mapOfFrames.values().stream().mapToInt(Integer::pa).sum();

        //   int sum = mapOfFrames.values().stream().mapToInt(Integer::parseInt).sum();

        int sum = mapOfFrames.values().stream().reduce(0, Integer::sum);


        return sum;
    }

    private Map<Integer, Integer> calculationOfLastFrame(final Map<Integer, Integer> mapOfFrames, int indextoCalculate, final int[] array) throws FrameNotSupportedException {
        int count = 1;
        try {
            while (count <= 2) {
                if (count != 2 && String.valueOf(Integer.valueOf(array[indextoCalculate])).equalsIgnoreCase("10")) {
                    if (String.valueOf(Integer.valueOf(array[indextoCalculate+1])).equalsIgnoreCase("10") && String.valueOf(Integer.valueOf(array[indextoCalculate + 2])).equalsIgnoreCase("10")) {
                        mapOfFrames.put(getNumberOFFrames(), 30);
                    } else {
                        mapOfFrames.put(getNumberOFFrames(), 10);
                    }
                    //count
                    break;
                    //  map.put();
                } else {
                    if (mapOfFrames.containsKey(getNumberOFFrames())) {
                        Integer ScoreForSpare;
                        try {
                            ScoreForSpare = Integer.valueOf(mapOfFrames.get(getNumberOFFrames())) + Integer.valueOf(array[indextoCalculate]);
                        } catch (ArrayIndexOutOfBoundsException aiob) {
                            throw new FrameNotSupportedException("Frame can not be in a proper way",aiob.getCause());
                        }

                        if (ScoreForSpare > 10) {
                            throw new FrameNotSupportedException("Frame sum can not be more than 10");
                        }
                        if (ScoreForSpare == 10) {
                            ScoreForSpare = ScoreForSpare + Integer.valueOf(String.valueOf(array[indextoCalculate + 1]));
                        }
                        mapOfFrames.put(getNumberOFFrames(), ScoreForSpare);
                        break;
                    } else {
                        mapOfFrames.put(getNumberOFFrames(), Integer.valueOf(array[indextoCalculate]));
                    }
                    count++;
                    indextoCalculate++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException aibe) {
          //  System.out.println("");
            aibe.printStackTrace();
            throw new FrameNotSupportedException("Frames Are not as expected",aibe);
        }
        return mapOfFrames;
    }

    public int calculateScores() throws FrameNotSupportedException {
        //char[] array = commaseperatedScores.toCharArray();
        if (getNumberOFFrames() > getCommaseperatedScores().length) {
            throw new FrameNotSupportedException("Number Of frames can not be gretter than length of scores");
        }
        int k = creationOfFrames(getCommaseperatedScores());
        return k;
    }


}

class FrameCalculator {

    public static void main(String[] args) throws FrameNotSupportedException {
//        int[] arrayOfInt = {4, 3, 10, 10, 7, 3, 4, 6, 10, 5, 3, 3, 5, 10, 10, 5, 5};
        int[] arrayOfInt = {7, 2, 4, 5, 2, 8, 0, 10, 6, 3, 8, 2, 6, 3,5,5};
        //int[] arrayOfInt = {4, 3, 10, 10, 7, 3, 4, 6, 10, 5, 3, 3, 5, 10, 10, 5, 5};
        FrameSumCalculator frameSumCalculator = new FrameSumCalculator(8, arrayOfInt);
        int valueOFSum = frameSumCalculator.calculateScores();
        System.out.println("valueOFSum :" + valueOFSum);
    }
}