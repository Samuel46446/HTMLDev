function resetTotal()
{
    localStorage.setItem('javaPoint', 0);
    localStorage.setItem('cppPoint', 0);
    localStorage.setItem('pythonPoint', 0);
    localStorage.setItem('webPoint', 0);
    localStorage.setItem('sqlPoint', 0);
    localStorage.setItem('csPoint', 0);
}
history.forward();
resetTotal();