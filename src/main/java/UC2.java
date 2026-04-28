public class UC2 {#include <iostream>
#include <cstdlib>
#include <ctime>

    using namespace std;
    void displayBoard(char board[3][3])
    {
        cout << "\n";

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                cout << " " << board[i][j];

                if(j < 2)
                    cout << " |";
            }

            cout << "\n";

            if(i < 2)
                cout << "---|---|---\n";
        }

        cout << "\n";
    }
    bool checkWinner(char board[3][3], char player)
    {
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player)
                return true;
        }
        for(int i = 0; i < 3; i++)
        {
            if(board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player)
                return true;
        }
        if(board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player)
            return true;

        if(board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player)
            return true;

        return false;
    }
    bool checkDraw(char board[3][3])
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j] != 'X' && board[i][j] != 'O')
                    return false;
            }
        }

        return true;
    }
    void playerMove(char board[3][3])
    {
        int row, col;

        while(true)
        {
            cout << "Enter row (1-3): ";
            cin >> row;

            cout << "Enter column (1-3): ";
            cin >> col;

            row--;
            col--;

            if(row >= 0 && row < 3 &&
                    col >= 0 && col < 3 &&
                    board[row][col] != 'X' &&
                    board[row][col] != 'O')
            {
                board[row][col] = 'X';
                break;
            }
            else
            {
                cout << "Invalid move! Try again.\n";
            }
        }
    }
    void computerMove(char board[3][3])
    {
        int row, col;

        while(true)
        {
            row = rand() % 3;
            col = rand() % 3;

            if(board[row][col] != 'X' &&
                    board[row][col] != 'O')
            {
                board[row][col] = 'O';
                break;
            }
        }

        cout << "Computer placed O at position: "
                << row + 1 << "," << col + 1 << endl;
    }
    int main()
    {
        char board[3][3] =
        {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        srand(time(0));
        cout << "===== TIC TAC TOE =====\n";
        cout << "Player = X\n";
        cout << "Computer = O\n";
        while(true)
        {
            displayBoard(board);
            playerMove(board);

            if(checkWinner(board, 'X'))
            {
                displayBoard(board);
                cout << "Congratulations! You win!\n";
                break;
            }
            if(checkDraw(board))
            {
                displayBoard(board);
                cout << "Game Draw!\n";
                break;
            }
            computerMove(board);

            if(checkWinner(board, 'O'))
            {
                displayBoard(board);
                cout << "Computer wins!\n";
                break;
            }
            if(checkDraw(board))
            {
                displayBoard(board);
                cout << "Game Draw!\n";
                break;
            }
        }
        return 0;
    }
}
