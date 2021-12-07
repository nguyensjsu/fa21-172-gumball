import mysql.connector
import pymongo
import datetime

class bcolors:
	HEADER = '\033[95m'
	OKBLUE = '\033[94m'
	OKCYAN = '\033[96m'
	OKGREEN = '\033[92m'
	WARNING = '\033[93m'
	FAIL = '\033[91m'
	ENDC = '\033[0m'
	BOLD = '\033[1m'
	UNDERLINE = '\033[4m'

delete_existing_documents = False

def migrate_table(db, table_name):
	mycursor = mysqldb.cursor(dictionary=True)
	mycursor.execute("SELECT * from users;")
	myresult = mycursor.fetchall()

	mycol = mydb[table_name]

	if delete_existing_documents:
		mycol.delete_many({})

	if len(myresult) > 0:
		x = mycol.insert_many(myresult)
		return len(x.inserted_ids)
	else:
		return 0

begin_time = datetime.datetime.now()
abort = False
print(f"Script started at: {begin_time}")

mysql_host="localhost"
mysql_database="cmpe172"
mysql_schema = "users"
mysql_user="admin"
mysql_password="welcome"

mongodb_host = "mongodb://localhost:27017/"
mongodb_dbname = "cmpe172"

if (delete_existing_documents):
	confirm_delete = input("Delete existing documents from collections (y)es/(n)o/(a)bort?")
	if confirm_delete.lower() == "a":
		abort = True
	elif confirm_delete.lower() == "n":
		delete_existing_documents = False
	else:
		#Confirm again
		confirm_delete = input("Are you sure (y)es/(n)?")
		if confirm_delete.lower() == "y":
			delete_existing_documents = True
		else:
			abort = True

if abort:
	print("Script aborted by user")
else:
	if (delete_existing_documents):
		print("Existing documents will be deleted from collections")
	else:
		print("Existing documents will not be deleted from collections")

print("Connecting to MySQL server...")
mysqldb = mysql.connector.connect(
	host=mysql_host,
	database=mysql_database,
	user=mysql_user,
	password=mysql_password
)

print("Connection to MySQL Server succeeded.")

print("Connecting to MongoDB server...")
myclient = pymongo.MongoClient(mongodb_host)
mydb = myclient[mongodb_dbname]
print("Connection to MongoDB Server succeeded.")

print("Migration started...")

dblist = myclient.list_database_names()
if mongodb_dbname in dblist:
	print("The database exists.")
else:
	print("The database does not exist, it is being created.")

table_list_cursor = mysqldb.cursor()
table_list_cursor.execute("SELECT * from users;")	
tables = table_list_cursor.fetchall()

total_count = len(tables)
success_count = 0
fail_count = 0

for table in tables:
	try:
		print(f"Processing table: {table[0]}...")
		inserted_count = migrate_table(mysqldb, str(table[0]))
		success_count += 1
		print(f"Processing table: {table[0]} completed. {inserted_count} documents inserted.")
	except Exception as e:
		fail_count += 1
		print(f"{e}")

print("Migration completed.")
print(f"{success_count} of {total_count} tables migrated successfully.")
if fail_count > 0:
	print(f"Migration of {fail_count} tables failed. See errors above.")
	
end_time = datetime.datetime.now()
print(f"Script completed at: {end_time}")
print(f"Total execution time: {end_time-begin_time}")

