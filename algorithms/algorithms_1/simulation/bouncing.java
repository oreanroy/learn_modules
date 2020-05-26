public class bouncing 
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Ball[] balls = new Ball[N];
        for (int i = 0; i<N; i++)
            balls[i] = new Ball();
        while(true)
        {
            StdDraw.clear();
            for(int i=0; i<N; i++)
            {
                balls[i].move(0.5);
                balls[i].draw();
            }
            StsDraw.show(50);
        }
    }
    public class Ball{
        private double rx, ry;
        private double vx, vy;
        private final double radius;
        public Ball(double rx, double ry, double vx, double vy, double radius){
            this.rx = rx;
            this.ry = ry;
            this.vx = vx;
            this.vy = vy;
            this.radius = radius;
        }
        public void move(double dt){
            if((rx+vx*dt < radius) || (rx+vx*dt > 1.0-radius)) { vx = -vx;}
            if((ry + vy*dt<radius) || (ry+vy*dt > 1.0-radius)) { vy = -vy;}
            rx = rx + vx*dt;
            ry = ry + vy*dt;
        }
        public void draw(){
            StdDraw.filledCircle(rx, ry, radius);}
}


                    

