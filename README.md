Sample dynamodb rest web service

Run the below commands after installing and starting a local dynamodb instance

#create local table
export AWS_ACCESS_KEY_ID=accessKey
export AWS_SECRET_ACCESS_KEY=secretKey
aws dynamodb create-table \
	--table-name Foos \
	--attribute-definitions AttributeName=id,AttributeType=S  \
	--key-schema AttributeName=id,KeyType=HASH \
	--provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
	--endpoint-url http://localhost:8000 \
	--region us-west-2

#run
mvn spring-boot:run -Drun.profiles=local


#Swagger docs can be found at
http://localhost:8080/swagger-ui.html