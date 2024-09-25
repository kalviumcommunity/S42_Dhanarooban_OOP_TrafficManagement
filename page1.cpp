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
        // Static member variable
        static int accountCount;

        // Constructor with dynamic memory allocation
        TrafficManagement(int Number_of_vehicles) {
            this->Number_of_vehicles = Number_of_vehicles;
            accountCount++;  // Increment static member variable when an object is created
        }

        // Static member function to get total objects created
        static int getTotalAccounts() {
            return accountCount;
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

        // Destructor
        ~TrafficManagement() {
            cout << "TrafficManagement object is being destroyed." << endl;
            accountCount--;  // Decrement static member variable when an object is destroyed
        }
};

// Define and initialize static member variable outside the class
int TrafficManagement::accountCount = 0;

int main() {  
    string a[4] = {"Road1", "Road2", "Road3", "Road4"};
    cout << a[1] << endl; 
    
    int Number_of_vehicles;
    cout << "Enter the number of vehicles: ";
    cin >> Number_of_vehicles;
    // Dynamically allocating memory for TrafficManagement object using `new`
    TrafficManagement* tm = new TrafficManagement(Number_of_vehicles);
    // Display total accounts using static member function
    cout << "Total Traffic Management objects created: " << TrafficManagement::getTotalAccounts() << endl;

    tm->TrafficManagementLogic();
    
    // Freeing dynamically allocated memory
    delete tm;

    // Display total accounts after deletion
    cout << "Total Traffic Management objects remaining: " << TrafficManagement::getTotalAccounts() << endl;
    
    return 0;
}
