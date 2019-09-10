#include <iostream>
#include <cstdio>

using namespace std;

int main(){
    int ans = 0;
    string s = NULL;
    cin >> s;
    string pairDelimiter = "";
    string delimiter = "";
    string res = "";
    
    int length = s.length();
    int mock=0;
    for(int i = 0; i < length; i++){
        if (s[i] == ' ') {
            if (pairDelimiter == ""){
                pairDelimiter = s.substr(mock, i);
                mock = i+1;
            }
            if (delimiter == ""){
                delimiter = s.substr(mock, i);
                mock = i+1;
            }
        }
        
    }
    int deLength = pairDelimiter.length();
    int count=0;
    
    for (int i =mock; i < length-deLength; i++)
    {
        if (pairDelimiter.compare(s.substr(i, i+deLength)))
        {
            count++;
            string _s = s.substr(mock, i);
            int _mock = 0;
            for (int j = 0; j < _s.length(); j++)
            {
                if (delimiter.compare(_s.substr(i, i+delimiter.length()))) {
                    res.append(_s.substr(0,i));
                    res.append(" ");
                    res.append(_s.substr(i+delimiter.length()));
                    res.append("\n");
                }
            }
            
        }
        
    }
    
    cout << ans << endl << res;
    return 0;
}