#include <bits/stdc++.h>
using namespace std;

int a[10005];
int n;

bool

vector<int> v;

set<int> s = {3, 5, 6};

multiset<int> s = {3, 5, 6};

//map<>

unordered_map<string, int> m;


void search(int p) {
    if (p == n) {
        for (int i : v) cout << i << ' ';
        cout << '\n';
        return;
    }
    search(p+1);
    v.push_back(p);
    serach(p+1);
    v.pop_back();

}

int main() {
    v.push_back(3); 
    v.pop_back();
    v.insert(0, 4); // 0(n)

    s.insert(4); //O(log n)

    (*(s.begin())); // get pointer of the last element
    (*(s.rbegin())); // get pointer of the last element
    s.erase(5); // erase 5
    s.erase(3); // erase both 3;

    for(int i : s) {
        // ??
    }

    cout << rand() << ' ' << rand() << ' ' << rand() << '\n'; // don't use c++ rand num

    cin << n;
    search(0);


}