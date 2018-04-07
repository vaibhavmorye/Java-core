
#DiskBacked Map Implementation: 
This is Implementaion of Disk Backed Map .
It is Currently have 3 methods 
#1.Add object.
#2.Find object.
#3.Remove object.

#To make method thread safe Lock are used.

#Add object : 
It add object to map, if count of object for instance for total size of map on heap exceed beyond certain threshold
then it remove 50% of ovject from heap and serialize then to disk.
to keep track of this object it store keys of element in arrayList.

#Find object:
It search first on heap if found return that object.
if object is not there then deserialize file and search object and if found return.

/** this funtion is under Improvement **
#Remove Object:
It Find that object on Heap if found remove.
if object is not there then search in file and skip that object and write all other object on anther file and set that file as original file.
it ask for new file name.
***/
