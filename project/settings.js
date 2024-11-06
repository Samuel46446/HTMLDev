javacPoint=0
cppPoint=0
pythonPoint=0
webPoint=0
sqlPoint=0

void addPoint(language)
{
    switch(language)
    {
        case "java":
            javacPoint=+1
            break
        case "cpp":
            cppPoint=+1
            break
        case "python":
            pythonPoint=+1
            break        
        case "web":
            webPoint=+1
            break
        case "sql":
            sqlPoint=+1
            break    
    }
}