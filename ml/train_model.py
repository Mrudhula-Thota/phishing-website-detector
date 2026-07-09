import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import joblib

# Load dataset
data = pd.read_csv("../dataset/phishing_dataset.csv")

# Input features
X = data[['length', 'https', 'numbers', 'at_symbol', 'hyphen', 'keyword']]

# Output label
y = data['label']

# Create model
model = RandomForestClassifier()

# Train model
model.fit(X, y)

# Save model
joblib.dump(model, "phishing_model.pkl")

print("Model trained successfully")