package utilz;

import main.Game;

public class Constants {
    
    public static class  UI {
        public static class  Buttons {
            public static final int B_WIDTH_DEFAULT=140;
            public static final int B_HEIGHT_DEFAULT=56;
            public static final int B_WIDTH= (int) (B_WIDTH_DEFAULT*Game.SCALE);
            public static final int B_HEIGHT= (int) (B_HEIGHT_DEFAULT*Game.SCALE);

             
        }
        
    }

    public static class Directions{
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
        public static final int UP = 1;             
    }

    public static class PlayerConstants{
        public static final int RUNNING = 1;
        public static final int IDLE = 0;
        public static final int JUMP = 5;
        public static final int FALLING = 6;
        // public static final int GROUND = 4;
        public static final int HIT = 8;
        public static final int ATTACK_1 = 3;
        public static final int ATTACK_JUMP_1 = 2;
        public static final int ATTACK_JUMP_2 = 4;

        public static int GetSpriteAmount(int  player_action){
            switch (player_action) {
                case RUNNING:
                    return 8;
                case IDLE:
                    return 10;
                case JUMP:
                    return 5;
                case FALLING:
                    return 1;
                case HIT:
                    return 8;
                case ATTACK_1:
                    return 8;
                case ATTACK_JUMP_1:
                    return 8;
                case ATTACK_JUMP_2:
                    return 8;
                default:
                    return -1;
            }
        }
    }


}
