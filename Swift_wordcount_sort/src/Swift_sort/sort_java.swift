type file;
#######################################################################################
file sort_jar<"swiftSort.jar">;	# this jar would  create CSV file  for a given text file

(file t) sort_func(file m, file j) { 
	#trace(@j);
    app {
	java "-jar" @j @m stdout = @filename(t); 
	}
}
#######################################################################################



file inputfile <"book.txt">;	#create input file
file outCSV_file <"outputSort.txt">;	#create output file


outCSV_file =  sort_func(inputfile, sort_jar); ## parameters are <inputu file, location of the jar file>












