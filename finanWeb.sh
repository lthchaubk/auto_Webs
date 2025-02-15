./lark_notifier.sh "------- Start DAILY Test -------"
for filename in ./src/main/java/proWeb3/testsuite/login/*; do
  filename=${filename#./src/main/java/}
  filename=${filename%.java}
  java -cp AutoWeb.jar $filename
done

for filename in ./src/main/java/proWeb3/testsuite/product/*; do
  filename=${filename#./src/main/java/}
  filename=${filename%.java}
  java -cp AutoWeb.jar $filename
done

for filename in ./src/main/java/proWeb3/testsuite/order/*; do
  filename=${filename#./src/main/java/}
  filename=${filename%.java}
  java -cp AutoWeb.jar $filename
done
./lark_notifier.sh "------- End DAILY Test -------"

#remove img file
for filename in ./test-output/img/*.png; do
  rm $filename
done

#remove log file
for filename in ./test-output/log/*.txt; do
  rm $filename
done

#remove report file
for filename in ./test-output/ReportCML/*.html; do
  rm $filename
done
