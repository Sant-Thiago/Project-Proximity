IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = "project_arduino")
BEGIN
    CREATE DATABASE project_arduino;
END
GO

USE project_arduino;
GO

/*
    sys.objects contém informações sobre todos os objetos (tabelas, vistas, procedimento armazenados, etc.) no banco de dados. 
    'type' indica o tipo de objeto
        - U: Tabela (User-defined table)
        - V: View
        - p: Procedure (Procedimento armazenado)
        - TR: Trigger 
*/
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Client]') AND type in (N'U'))
BEGIN
    CREATE TABLE Client (
        Id INT IDENTITY(1,1) PRIMARY KEY,
        Name NVARCHAR(255),
        CPF BIGINT
    );
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Led]') AND type in (N'U'))
BEGIN
    CREATE TABLE Led (
        Id INT IDENTITY(1,1) PRIMARY KEY,
        Client INT,
        MinBrightnessPercent FLOAT,
        Location NVARCHAR(255),
        FOREIGN KEY (Client) REFERENCES Client(Id) ON DELETE CASCADE
    );
END
GO

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Info_Led]') AND type in (N'U'))
BEGIN
    CREATE TABLE Info_Led (
        Id INT IDENTITY(1,1) PRIMARY KEY,
        Led INT,
        Data Date,
        StatusLed BIT,
        UnconsumedEnergy FLOAT,
        SavedMoney FLOAT,
        FOREIGN KEY (Led) REFERENCES Led(Id) ON DELETE CASCADE
    );
END
GO

