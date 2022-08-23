### Input data:
"Dave","Smith","123 main st.","seattle","wa","43"
"Alice","Smith","123 Main St.","Seattle","WA","45"
"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"
"Carol","Johnson","234 2nd Ave","Seattle","WA","67"
"Eve","Smith","234 2nd Ave.","Tacoma","WA","25"
"Frank","Jones","234 2nd Ave.","Tacoma","FL","23"
"George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"
"Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"
"Ian","Smith","123 main st ","Seattle","Wa","18"
"Jane","Smith","123 Main St.","Seattle","WA","13"

### Expected output:
Each household and number of occupants, followed by:
Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is older than 18

#### running application
  
from command line run the following commands:  

    `cd expeditors/src`

Compile code  

    `javac Application.java`

run the program with passing a filepath variable. Below is just an example file.  

    `java Application -test.txt`

