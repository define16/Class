import numpy as np
import pandas as pd
# import openpyxl as xl


np.random.seed(20180917)
t_idx = pd.date_range('9/17/2018', periods=1000)
df = pd.DataFrame(np.random.randn(1000,4), index=t_idx, columns=['A','B','C','D'])

print(df)
# xl.to_csv('csc_test.csv')
df.to_excel('excel_test.xlsx', sheet_name='DataFrame', engine='xlsxwriter')