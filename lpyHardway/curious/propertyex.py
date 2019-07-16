class PeopleHeight:
    def __init__(self, height = 150):
        self.set_height = height

    def convert_to_inches(self):
        return (self.height * 0.3937)

    def get_height(self):
        print("Inside the getter method")
        return self._height

    def set_height(self, value):
        if value < 0:
            raise ValueError("Height cannot be negative")
        print("Inside the setter method")
        self._height = value

    height = property(get_height, set_height)
