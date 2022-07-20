IF NOT EXISTS (
    SELECT  1
    FROM    sys.schemas
    WHERE   name = N'pets'
)
    EXEC('CREATE SCHEMA [pets]');
GO

