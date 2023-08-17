import { AcGameObject } from "./AcGameObject";
import { Wall } from "./Wall";
import {Snake} from "./Snake"
export class GameMap extends AcGameObject {
    constructor(ctx, parent) {
        super();
        this.ctx = ctx;
        this.parent = parent;
        this.L = 0;

        this.rows = 13;
        this.cols = 14;
        this.innner_walls_count = 20;
        this.walls = []

/*         this.snakes = [
            new Snake({id:0,color:"#4876EC",r:this.rows-2,c:1},this),
            new Snake({id:1,color:"#F94848", r:1,c:this.cols-2},this),
        ] */
        this.snakes = [
            new Snake({id: 0, color: "#4876EC", r: this.rows - 2, c: 1}, this),
            new Snake({id: 1, color: "#F94848", r: 1, c: this.cols - 2}, this),
        ];

    }

    check_connectivity(g,sx,sy,ex,ey){
        if(sx == ex && sy == ey) return true;
        g[sx][sy] = true;
        let dx = [0,0,1,-1],dy = [1,-1,0,0];
        for(let i = 0;i < 4;i++){
            let x = sx + dx[i],y = sy + dy[i];
            if(!g[x][y] && this.check_connectivity(g,x,y,ex,ey)) return true;

        }
        return false;
    }

    check_valid(cell){ //判断蛇走的位置是否合法
        //判断障碍物
        for(const wall of this.walls){
            if(cell.r === wall.r && cell.c === wall.c)
                return false;
        }
        //判断蛇的身体
        for(const snake of this.snakes){
            let k = snake.cells.length;
            //判断是否该蛇有加长度，如果没有加长度的话，我们需要判断的数量少1，
            if(!snake.check_tail_increasing()) k--;
            for(let i = 0;i < k;i++){
                if(snake.cells[i].r === cell.r && snake.cells[i].c === cell.c)
                    return false;
            }
        }
        return true;
    }

    check_ready(){//判断两条蛇是否都准备好下一回合 即
        for(const snake of this.snakes){
            if(snake.status !== "static") return false;
            if(snake.direction === -1) return false;
        }
        return true;
    }


    create_walls(){
        
        const g = [];
        for(let r = 0;r < this.rows;r++){
            g[r] = []
            for(let c = 0; c < this.cols;c++){
                g[r][c] = false;
            }
        }
        //设置地图两边的障碍物
        for(let r = 0;r < this.rows;r++){
            g[r][0] = g[r][this.cols-1] = true;
        }

        for(let c = 0; c < this.cols;c++){
            g[0][c] = g[this.rows-1][c] = true;
        }

        //设置随机障碍物 中心对称

        for(let i = 0; i < this.innner_walls_count / 2;i++){
            for(let j = 0;j < 1000;j++){
                let r = parseInt(Math.random() * this.rows);
                let c = parseInt(Math.random() * this.cols);
                if(g[r][c] || g[this.rows - 1 - r][ this.cols - 1 - c]) continue; // x' = rows - 1 - x, y' = cols - 1 - y
                if(r == this.rows - 2 && c ==1 || r == 1 && c == this.cols- 2 ) continue;
                g[r][c] = g[this.rows - 1 - r][ this.cols - 1 - c] = true;
                break;
            }
        }

        const copy_g = JSON.parse(JSON.stringify(g));

        if(!this.check_connectivity(copy_g,this.rows-2,1,1,this.cols-2)) return false;

        for(let r = 0; r < this.rows;r++){
            for(let c = 0; c < this.cols;c++)
                if(g[r][c])
                    {
                        this.walls.push(new Wall(r,c,this));
                    }
        }

        return true;
    }


    add_listening_events() {
        this.ctx.canvas.focus();

        const [snake0, snake1] = this.snakes;
        this.ctx.canvas.addEventListener("keydown", e => {
            if (e.key === 'w') {
                snake0.set_direction(0);
               /*  console.log("w"); */
            }
            else if (e.key === 'd') snake0.set_direction(1);
            else if (e.key === 's') snake0.set_direction(2);
            else if (e.key === 'a') snake0.set_direction(3);
            else if (e.key === 'ArrowUp') snake1.set_direction(0);
            else if (e.key === 'ArrowRight') snake1.set_direction(1);
            else if (e.key === 'ArrowDown') snake1.set_direction(2);
            else if (e.key === 'ArrowLeft') snake1.set_direction(3);
            /* console.log(snake0.direction);
            console.log(snake1.direction); */
/*             console.log(snake0.status);
            console.log(snake1.status); */
        });
    }


    start() {
        for(let i = 0;i < 1000;i++)
            if(this.create_walls())
                break;

        this.add_listening_events();
    }

    update_size() {
        this.L = parseInt(Math.min(this.parent.clientWidth / this.cols, this.parent.clientHeight / this.rows));
        this.ctx.canvas.width = this.L * this.cols;
        this.ctx.canvas.height = this.L * this.rows;
    }

    next_step(){
        for(const snake of this.snakes){
            snake.next_step();
        }
    }

    update() {
        this.update_size();

        if(this.check_ready()){
            this.next_step();
        }
       
        this.render();
    }

    render() {
        //this.ctx.fillStyle = 'green';
        //this.ctx.fillRect(0,0,this.ctx.canvas.width,this.ctx.canvas.height);
        const color_odd = '#abd653', color_even = '#a2d048';
        for (let i = 0; i < this.rows; i++)
            for (let j = 0; j < this.cols; j++) {
                if ((i + j) % 2 == 0) {
                    this.ctx.fillStyle = color_even;
                }
                else {
                    this.ctx.fillStyle = color_odd;
                }
                this.ctx.fillRect(this.L * j,this.L * i,this.L,this.L);
            }


    }
}