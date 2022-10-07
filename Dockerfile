FROM openjdk:8-jre
MAINTAINER "usdt"
LABEL description="usdt-server"
ADD ./grg_test-0.1.jar /project/test/grg_test-0.1.jar
ENV TZ=Asia/Shanghai
EXPOSE 8088
#CMD java -jar -Duser.timezone=GMT+08 -server -XX:+HeapDumpOnOutOfMemoryError -Xms512m -Xmx512m ruoyi-admin.jar
CMD ["java","-jar","-Duser.timezone=GMT+08 -server","-XX:+HeapDumpOnOutOfMemoryError","/project/test/grg_test-0.1.jar"]
