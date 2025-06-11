from transformers import pipeline

analyzer = pipeline("sentiment-analysis")

def analyze_feeling(texto: str):
    result = analyzer(texto)[0]
    return result['label'].lower(), float(result['score'])
