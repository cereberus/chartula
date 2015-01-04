public class pole_pcr_nn{
int inputSize = 3;
int hiddenSize = 2;
int outputSize = 2;
double[] hiddenValues = new double[hiddenSize];
double[] outputValues = new double[outputSize];
double[] inputValues = new double[inputSize];
double[][] hiddenWeights = new double[][]{
{-2.38723310249,-7.62039069106,1.3023691819},
{2.00950796141,-9.1508554255,4.45369797131},
};
double[] hiddenBiases = new double[]{-0.298046105109,-0.368326323723};
double[][] outputWeights = new double[][]{
{-2.34813909147,-1.8138989197},
{1.67636029146,1.90889636906},
};
double[] outputBiases = new double[]{-1.86029936331,2.69462449923};
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
public int getClass(double[] Input){
  inputValues = Input;
  calcHiddenValues();
  calcOutputValues();
  return outputValue();
}

}
