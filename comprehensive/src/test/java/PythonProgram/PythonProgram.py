import math

class Circle:
    def __init__(self, radius):
        self.radius = radius


    def getArea(self):
        cirArea = math.pi * self.radius ** 2
        print("Area of Circle: ",{cirArea})
        return cirArea


class Cylinder(Circle):
    def __init__(self, radius, height):
        super().__init__(radius) 
        self.height = height


    def getArea(self):
        cylArea = 2 * math.pi * self.radius * self.height
        print("Lateral Surface Area of Cylinder:" ,{cylArea})
        return cylArea


    def getVolume(self):
        volume = math.pi * self.radius ** 2 * self.height
        print("Volume of Cylinder: ",{volume})
        return volume


if __name__ == "__main__":
    cyl = Cylinder(7, 5)
    cyl.getArea()     
    cyl.getVolume() 
    
    cir = Circle(10)
    cir.getArea()
    
      
