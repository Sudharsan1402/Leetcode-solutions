class Solution {
public:
    int search(vector<int>& nums, int target) {
        auto it = find(nums.begin(), nums.end(), target);
        if (it != nums.end()) {
            int index = it - nums.begin();
            return index;
        }else{
            return -1;
        }
        
    }
};