
%%
clc;
clear all;
close all;
start= fullfile('F:','ecg','dataset1');
allsfolder=genpath(start);
remain=allsfolder;
listoffolder={};
while true
    [singlesubfolder, remain]=strtok(remain,';');
    if isempty(singlesubfolder)
        break;
    end
    listoffolder= [listoffolder singlesubfolder];
end
numberoffolder=length(listoffolder);
features=[];
label=[];

for k=1: numberoffolder
    thisfolder=listoffolder{k};
    filepattern=sprintf('%s/*.txt',thisfolder);
    basefile=dir(filepattern);
    nofiles=length(basefile);
    if nofiles>=1
        for f=1:nofiles
            filename=fullfile(thisfolder,basefile(f).name);
            [feature_array]=feature_extraction(filename);
            %data=importdata(filename);
            %sig=data.';
            %fs=100;
            %gr=0;
%             int=[];
%             [qrs_amp_raw,qrs_i_raw,delay]=pan_tompkin(sig,fs,gr);
%             for i=1:1:length(qrs_i_raw)-1
%                 int(i)=(qrs_i_raw(i+1)-qrs_i_raw(i))*0.0027777;
%             end
%             len=length(qrs_i_raw);
%             rr_interval= zeros(1,len);
%             rr_interval(1)= qrs_i_raw(1)/fs;
%             for i=2:1:len
%               rr_interval(i)=(qrs_i_raw(i)-qrs_i_raw(i-1))/fs;
%             end
            
            features=[features ; feature_array ];
            if(thisfolder==fullfile(start,'arryt'))
                label=[label; 1];
            
            elseif(thisfolder==fullfile(start,'norma'))
                    label=[label; 0];
            end
        end
    end
            
end

%%svm
SVMModel = fitcsvm(features,label,'Standardize',true,'KernelFunction','RBF','KernelScale','auto');
CVSVMModel = crossval(SVMModel);
classLoss = kfoldLoss(CVSVMModel);
[outputs,score] = predict(SVMModel,features);
%table(YTest(1:10),label(1:10),score(1:10,2),'VariableNames',{'TrueLabel','PredictedLabel','Score'})
plotconfusion(label.',outputs.');