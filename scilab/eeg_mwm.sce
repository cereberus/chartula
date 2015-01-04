eeg_data=csvRead("baseline_raw.csv");
eeg_att_med=csvRead("esense_raw.csv");
///////

[wier_eeg kol_eeg]=size(eeg_data);
[wier_a_m kol_a_m]=size(eeg_att_med);
//loop to calculate millivolts from raw signal
for i=1:1:wier_eeg
    eeg_data(i,2)=((eeg_data(i,2)*(1.8/4096))/2000)*1000;
end
//

//tworzy wykres atencji do czasu
figure();
a=gca();  
a.data_bounds=[0 0;15 100];
a.font_size=5;

f=get("current_figure")
f.figure_size=[1200,400]

title("Attention level during the examination","fontsize",6);
xlabel("seconds (s)","fontsize",5);
ylabel("attention level","fontsize",5);
plot(eeg_att_med(:,1),eeg_att_med(:,2),'rd-'); 
////////////////////

//tworzy wykres medytacji do czasu
figure();
a=gca();  
a.data_bounds=[0 0;15 100];
a.font_size=5;

f=get("current_figure")
f.figure_size=[1200,400]

title("Meditation level during the examination","fontsize",6);
xlabel("seconds (s)","fontsize",5);
ylabel("meditation level","fontsize",5);
plot(eeg_att_med(:,3),eeg_att_med(:,4),'kd-');
///////////////////

//tworzy wykres sygnalu do czasu
figure();
a=gca();  
a.font_size=5;

f=get("current_figure")
f.figure_size=[1200,400]

title("EEG signal in millivolts over the time","fontsize",6);
xlabel("seconds (s)","fontsize",5);
ylabel("millivolts (mV)","fontsize",5);
plot(eeg_data(:,1),eeg_data(:,2),'b-');

/////////
disp("")

signal_mean = mean(eeg_data(:,2));
disp("signal_mean")
disp(signal_mean)
disp("")

signal_stdev = stdev(eeg_data(:,2));
disp("signal_stdev")
disp(signal_stdev)
disp("")

signal_variance = variance(eeg_data(:,2));
disp("signal_variance")
disp(signal_variance)
disp("")

att_med_correl = correl(eeg_att_med(:,2),eeg_att_med(:,1));
disp("attention_level meditation_level corelation")
disp(att_med_correl)
disp("")
/////

signal_mean_range = 0
counter=0
for i=1:1:wier_eeg
    if eeg_data(i, 1)>4 & eeg_data(i, 1)<8  
        signal_mean_range = signal_mean_range + eeg_data(i,2);
        counter=counter+1;
    end
end

signal_mean_range=signal_mean_range/counter
disp("What is mean signal value between 4th and 8th second?")
disp("signal_mean_range in range 4-8 seconds")
disp(signal_mean_range)


mean_att = 0;
mean_med = 0;
for i=1:1:wier_a_m
    mean_att = mean_att + eeg_att_med(i,2);
    mean_med = mean_med + eeg_att_med(i,4);
end

//whether  the meditation or the attention is higher
mean_att=mean_att/wier_a_m;
mean_med=mean_med/wier_a_m;
disp("")
disp("Is the mean attention higher or the mean meditation?")
if mean_att>mean_med then
    disp("Mean attention is higher with the value:")
    disp(mean_att)
    disp("While mean meditation is:")
    disp(mean_med)        
elseif mean_att<mean_med then
    disp("Mean meditation is higher with the value:")
    disp(mean_med)    
    disp("While mean attention is:")
    disp(mean_att)
end
