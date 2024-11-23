class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length, cols = box[0].length, dots = 0;
        char[][] rotated = new char[cols][];
        for(int c=0;c<cols;c++)
            rotated[c] = new char[rows];

        for(int r=0;r<rows;r++)
        {
            int colIdxInRotate = rows-1-r, row = dots = 0;
            for(int c=0;c<cols;c++)
                if(box[r][c]=='.')
                    dots++;
                else if(box[r][c]=='*')
                {
                    while(--dots>=0)
                        rotated[row++][colIdxInRotate]='.';
                    while(row < c)
                        rotated[row++][colIdxInRotate]='#';
                        
                    rotated[row++][colIdxInRotate]='*';
                    // reset dots counter
                    dots = 0;
                }
            
            while(--dots>=0)
                rotated[row++][colIdxInRotate]='.';
            while(row < cols)
                rotated[row++][colIdxInRotate]='#';
        }
        return rotated;
    }
}