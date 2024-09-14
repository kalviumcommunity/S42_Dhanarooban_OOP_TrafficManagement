#include <iostream>
#include <chrono> 
#include <thread> 
#include <string> 

using namespace std;

class TrafficManagement {
    private:
        string signal;
        int Number_of_vehicles;
    
    public:
        // Constructor with dynamic memory allocation
        TrafficManagement(int Number_of_vehicles) {
            this->Number_of_vehicles = Number_of_vehicles;
        }
    
        // Traffic management logic function
        void TrafficManagementLogic() {
            if (Number_of_vehicles >= 50) {
                signal = "Red";
                cout << "Red" << endl;
                this_thread::sleep_for(chrono::seconds(1));
                for (int i = 1; i <= 5; i++) {
                    cout << i << endl;
                    this_thread::sleep_for(chrono::seconds(1));
                }
             
                signal = "Yellow";
                cout << signal << endl;
                this_thread::sleep_for(chrono::seconds(1));
                for (int i = 1; i <= 5; i++) {
                    cout << i << endl;
                    this_thread::sleep_for(chrono::seconds(1));
                }
             
                signal = "Green";
                cout << signal << endl;
            } else {
                signal = "Green";
                cout << signal << endl;
            }
        }

        // Destructor to clean up resources (if needed)
        ~TrafficManagement() {
            cout << "TrafficManagement object is being destroyed." << endl;
        }
};

int main() {  
    string a[4] = {"Road1", "Road2", "Road3", "Road4"};
    cout << a[1] << endl; 
    
    int Number_of_vehicles;
    cout << "Enter the number of vehicles: ";
    cin >> Number_of_vehicles;
    
    // Dynamically allocating memory for TrafficManagement object using `new`
    TrafficManagement* tm = new TrafficManagement(Number_of_vehicles);
    
    // Call the traffic management logic
    tm->TrafficManagementLogic();
    
    // Deallocating memory using `delete`
    delete tm;
    
    return 0;
}
