# Load the neccessary .NET asssembly
Add-Type -Path "C:\Program Files (x86)\MySQL\MySQL Connector NET 8.3.0\MySQL.Data.dll"

# Define MySQL server
$server = "127.0.0.1"
$database = "AlgorithmWiki"
$user = "root"
$password = Read-Host "Enter MySQL password (root): " -AsSecureString