package grik.sieci;

public class klocek_pcr_nn{
int inputSize = 3;
int hiddenSize = 3;
int outputSize = 3;
double[] hiddenValues = new double[hiddenSize];
double[] outputValues = new double[outputSize];
double[] inputValues = new double[inputSize];
double[][] hiddenWeights = new double[][]{
{-2.08675710424,3.14081264049,-4.80279056124},
{3.48244491202,-1.16969311217,-4.50559585027},
{-5.92046455402,6.14495562432,-9.96052728634},
};
double[] hiddenBiases = new double[]{-0.264491456223,-0.421662093338,-0.390067161022};
double[][] outputWeights = new double[][]{
{-1.93904395602,0.150741441717,5.57190936497},
{-2.88416971152,-1.67716817149,-0.560264578004},
{-1.57341814059,2.54468074392,-0.986408489581},
};
double[] outputBiases = new double[]{3.91332008611,-1.86832758552,-0.0329412907037};
public void calcHiddenValues(){
  double sum=0;
  for (int h=0;h<hiddenSize;h++){
    sum=0;
    for (int i=0;i<inputSize;i++){
      sum += hiddenWeights[h][i] * inputValues[i];
    }
    sum=sum+hiddenBiases[h];
    hiddenValues[h] = (Math.pow(Math.E, sum)-Math.pow(Math.E, -sum))/(Math.pow(Math.E, sum)+Math.pow(Math.E, -sum));
  }
}

public void calcOutputValues(){
  double sum=0;
  for (int out=0;out<outputSize;out++){
    sum=0;
    for (int h=0;h<hiddenSize;h++){
      sum += outputWeights[out][h] * hiddenValues[h];
    }
    sum=sum+outputBiases[out];
    outputValues[out] = (Math.pow(Math.E, sum)-Math.pow(Math.E, -sum))/(Math.pow(Math.E, sum)+Math.pow(Math.E, -sum));
  }
}
public int outputValue(){
  int out = -1;
double max=-100.0;
  for (int i=0;i<outputSize;i++){
    if (outputValues[i] > max){
    max=outputValues[i];
      out=i;
    }
  }
  return out;
}
public static int getClass(double[] Input){
  inputValues = Input;
  calcHiddenValues();
  calcOutputValues();
  return outputValue();
}

}
