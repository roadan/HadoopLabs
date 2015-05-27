DATASET_FOLDER=/Users/roadan/Work/Courses/Hadoop-New/HadoopLabs/data/

for i in {1904..1977}
do
 #cd $DATASET_FOLDER/$i

 # Un-gzip each station file and concat into one file
 #echo "reporter:status:Un-gzipping  $DATASET_FOLDER/$i" 
 
 #for file in  $DATASET_FOLDER/$i/*; do
 # gunzip -c $file >> $DATASET_FOLDER/$i/data.all
 # echo "reporter:status:Processed $file" 
 #done

 #gzip $DATASET_FOLDER/$i/data.all 
 mv $DATASET_FOLDER/$i/data.all.gz $DATASET_FOLDER/flat/$i.gz
 echo "reporter:status:flatten  $DATASET_FOLDER/flat/$i.gz"
done

	



 
