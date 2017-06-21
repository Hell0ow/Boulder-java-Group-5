package controller;

import Icontroller.IOrder;

public enum Order implements IOrder{
	MOVE_UP, MOVE_RIGHT, MOVE_DOWN, MOVE_LEFT, DIG_UP, DIG_RIGHT, DIG_DOWN, DIG_LEFT, NONE;
}
