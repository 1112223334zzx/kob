import { AcGameObject } from "./AcGameObject";

export class Cell extends AcGameObject{
    constructor(r,c){
        super();
        this.r = r;
        this.c = c;
        this.x = c + 0.5;
        this.y = r + 0.5; //canvas坐标系与常规坐标系坐标轴相反

    }
}