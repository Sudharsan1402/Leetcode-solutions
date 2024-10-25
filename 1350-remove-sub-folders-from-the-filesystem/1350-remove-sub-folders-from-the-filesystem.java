class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        Arrays.sort(folder);
        list.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            if(!folder[i].startsWith(list.get(list.size()-1)+"/")){
                list.add(folder[i]);
            }
        }
        return list;
    }
}