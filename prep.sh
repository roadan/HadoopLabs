DATASET_FOLDER=/Users/roadan/Work/Courses/Hadoop-New/Labs/data/

for i in {1901..1977}
do
 #cd $DATASET_FOLDER/$i

 # Un-gzip each station file and concat into one file
 echo "reporter:status:Un-gzipping  $DATASET_FOLDER/$i" 
 
 for file in  $DATASET_FOLDER/$i/*; do
  gunzip -c $file >> $DATASET_FOLDER/$i/data.all
  echo "reporter:status:Processed $file" 
 done

 gzip $DATASET_FOLDER/$i/data.all 
 
done

	



 
