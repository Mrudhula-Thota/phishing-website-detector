import joblib
import sys

# Load trained model
model = joblib.load("phishing_model.pkl")

# Read input values
length = int(sys.argv[1])
https = int(sys.argv[2])
numbers = int(sys.argv[3])
at_symbol = int(sys.argv[4])
hyphen = int(sys.argv[5])
keyword = int(sys.argv[6])

# Make prediction
result = model.predict([[length, https, numbers, at_symbol, hyphen, keyword]])

print(result[0])