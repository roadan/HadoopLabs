# Pig

![Hadoop Logo](http://www.datameer.com/images/technology/hadoop-pic1.png)

## Overview

**This is the lab for module 6 in the Hadoop courese**,  *the labs will take you through the process of developing Apache Pig data-flows*.


#### Exercise 1 - Loading the data
	
- Open the **Module 6/data** folder in the course's git repository, the folder contains two files:
  - **NYSE_daily_prices_A.csv**: a file containing containing daily prices of different stocks in the NY stock exchange.
  - **NYSE_dividends_A.csv**: a file containing containing dividends for the same stocks.
- Upload the files to **/user/cloudera/pigin/** in HDFS
- Open the Pig editor in HUE and create a new pig script. 
- Load the two files using the following code:


```PigLatin
STOCKS = LOAD '/user/cloudera/pigin/NYSE_daily_prices_A.csv' using PigStorage(',') AS (exchange:chararray, symbol:chararray, date:chararray, open:float, high:float, low:float, close:float, volume:int, adj_close:float);

DIVIDENDS = LOAD '/user/cloudera/pigin/NYSE_dividends_A.csv' using PigStorage(',') AS (exchange:chararray, stock_symbol:chararray, date:chararray, dividends:float)

```


#### Exercise 2 - Transfor the data

For this exercise you can use the pig latin basics page in the [Apache Pig website]
(http://pig.apache.org/docs/r0.14.0/basic.html#filter)
- Join STOCKS and DIVIDENDS to a new alias called STOCKS_AND_DIV.
- create a new alias called LARGE_VOL containing STOCKS_AND_DIV rows with volume grater then 200000.
- crate an alias called STOCKS_SLIM containing only the following fileds: exchange, symbol, volume from the STOCKS alias and dividends from the DIVIDENDS alias.
- Store STOCKS_SLIM as a JSON file in '/user/cloudera/pigout/stocks.json'
