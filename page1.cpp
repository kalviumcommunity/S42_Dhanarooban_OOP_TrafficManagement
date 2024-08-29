#include <iostream>
using namespace std;
#include <chrono> 
#include <thread> 

class TrafficManagement{
    private:
    string signal;
    int  Number_of_vehicles;
    
    public:
    TrafficManagement( int Number_of_vehicles){
        this->Number_of_vehicles = Number_of_vehicles;
    };
    
    void TrafficManagementLogic(){
        
        if (Number_of_vehicles>=50){
             signal = "Red";
             cout << "Red" << endl;
             this_thread::sleep_for(chrono::seconds(1));
             for (int i=1 ;i<=5;i++){
                 cout << i <<endl;
                 this_thread::sleep_for(chrono::seconds(1));
             };
             
             
             signal = "yellow";
             cout << signal << endl;
             this_thread::sleep_for(chrono::seconds(1));
             for (int i=1;i<=5;i++){
                 cout << i <<endl;
                 this_thread::sleep_for(chrono::seconds(1));
             };
             
             signal = "Green";
             cout << signal << endl;
    }  else{
            signal = "Green";
            cout << signal << endl;
        };
        
    }
};

int main(){  
    int Number_of_vehicles;
    cin >> Number_of_vehicles;
    TrafficManagement tm(Number_of_vehicles);
    tm.TrafficManagementLogic();
    return 0;
}