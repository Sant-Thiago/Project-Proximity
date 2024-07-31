#!/bin/bash

/opt/mssql/bin/sqlservr &

echo "Esperando o SQL Server iniciar..."
while ! /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P "Senha123" -Q "SELECT 1" &> /dev/null
do 
    echo "Aguardando o SQL Server estar pronto..."
    sleep 5
done

echo "Executando o script de inicialização..."
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P "Senha123" -i /usr/src/app/init-database.sql

wait