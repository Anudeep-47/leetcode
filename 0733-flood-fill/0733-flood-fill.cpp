class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int old_color { image[sr][sc] };
        if (old_color == color) return image;
        int nr { static_cast<int>(image.size()) }, nc { static_cast<int>(image[0].size()) };
        queue<pair<int, int>> pixel_q {};
        pixel_q.push({sr, sc});
        while (!pixel_q.empty()) {
            int r { pixel_q.front().first }, c { pixel_q.front().second };
            pixel_q.pop();
            image[r][c] = color;
            if (r > 0 && image[r-1][c] == old_color) pixel_q.push({r-1, c});
            if (r+1 < nr && image[r+1][c] == old_color) pixel_q.push({r+1, c});
            if (c > 0 && image[r][c-1] == old_color) pixel_q.push({r, c-1});
            if (c+1 < nc && image[r][c+1] == old_color) pixel_q.push({r, c+1});
        }
        return image;
    }
};