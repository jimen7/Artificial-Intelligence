

@echo off
FOR /L %%A IN (1, 1, 7) DO (
echo running demo%%A

caveroute demo%%A
java -jar validate.jar demo%%A

)

