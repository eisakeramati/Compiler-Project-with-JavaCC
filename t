echo "----- Test $1"
java -classpath .:./AST TestHL ../Test/Inputs/$1.hl >../Test/Outputs/$1
diff -B ../Test/Outputs/$1 ../Test/Results/$1
