import sys
import pickle
import sklearn
import pandas as pd
import os

filename = f'{os.path.dirname(os.path.abspath(__file__))}/model.pkl'
f = open(filename, 'rb')
model = pickle.load(f)
f.close()

month = sys.argv[1]
year = sys.argv[2]

data = {
    "1": [month, year, 1],
    "2": [month, year, 2],
    "3": [month, year, 3],
    "4": [month, year, 4],
    "5": [month, year, 5],
    "6": [month, year, 6]
}

df = pd.DataFrame.from_dict(data, orient='index', columns=['month', 'year', 'brigade'])

lst = [round(item, 2) for item in model.predict_proba(df)[:, 1]]
    
sys.stdout.write(f'{lst}')