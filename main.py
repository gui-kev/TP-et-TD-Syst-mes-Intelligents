import csv
import numpy as np
from character import Character
from army import Army
from Perceptron import Perceptron
import matplotlib.pyplot as plott

def CreerArme(character_list, army_list = list()):
    for character in character_list:
        army_list.append(Army(character))

    return army_list

def TotalValeurArme(army_list):
    total = 0.0
    for army in army_list:
        total += army.getTotalMorale()

    return total

if __name__ == "__main__":
    character_list = list()
    army_list = list()

    PremiereLigne = True
    with open('characters.csv', 'r') as file:
        myreader = csv.reader(file)
        for row in myreader:
            if PremiereLigne:
                PremiereLigne = False
            else:
                character_list.append(Character(row[0], row[1], row[2], row[3], float(row[4])))

    army_list = CreerArme(character_list, army_list)

    total = TotalValeurArme(army_list)
    print("Le Boost total est: "+str(total))

    #TD2


    a = [[0,0],[0,1],[1,0],[1,1]]
    t = [0,0,0,1]
    y=[]
    error = np.zeros([11,11])
    index = [0,0]
    for w1 in range(-5,6):
        for w2 in range(-5,6):
            y = []
            for i in a:
                temp = w1*i[0]+w2*i[1]
                if(temp<=0):
                    y.append(0)
                else:
                    y.append(1)
            temp2 = 0.0
            for i in range(0,4):
                temp2 += 0.5*(y[i]-t[i])**2

            error[index[0]][index[1]] = temp2
            index[1] += 1
        index[1] = 0
        index[0] += 1
    plott.imshow(error)
    plott.show()


    perceptron = Perceptron(3, 400, 1e-4)
    x = [
        [1, 0, 0],
        [1, 0, 1],
        [1, 1, 0],
        [1, 1, 1]
    ]
    y = [0, 0, 0, 1]

    print(perceptron.train(x, y))

    print(perceptron.get_poids())

    with open("data.csv", "w") as file:
        writer = csv.writer(file)
        writer.writerow(["w1", "w2", "w3"])
        writer.writerow(perceptron.get_poids())