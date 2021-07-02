
# coding: utf-8

# In[53]:

import requests
import json
url = "http://localhost:8098"
prefix = "/buckets/s23685/keys/WL"


# In[54]:

d = {"name": "Wiwiana", "surname": "Lebiodzik", "age": 25}
response = requests.post(url+prefix, json=d)


# In[55]:

response = requests.get(url+prefix, data = {'key':'value'})


# In[56]:

d = response.text
#print(d)
h = json.loads(d)
print(h)


# In[57]:

h["name"] = 'Klaudia'
print(h)
response = requests.post(url+prefix, json=h)


# In[58]:

response = requests.get(url+prefix, data = {'key':'value'})


# In[59]:

print(response.text)


# In[60]:

response = requests.delete(url+prefix)


# In[61]:

response = requests.get(url+prefix, data = {'key':'value'})


# In[62]:

print(response.text)


# In[ ]:



