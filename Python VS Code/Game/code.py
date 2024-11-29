import random #random number generation
import sys
import pygame
from pygame.locals import *




#global variables 
FPS = 60
SCREENHEIGTH=1920
SCREENWIDTH=1080
SCREEN=pygame.display.set_mode((SCREENWIDTH,SCREENHEIGTH))
BASE= SCREENHEIGTH * 0.8
PLAYER='/Gallery/Sprites/plane'
GAME_SOUND = {
    
}
GAME_SPRITES = {
    
}

if __name__ == "__main__":
    #the main function
    pygame.init()
    clock=pygame.time.Clock()
    pygame.display.set_caption("The 9/11 project")
    GAME_SPRITES['numbers']=(
        pygame.image.load('').convert_alpha(),
    )
    