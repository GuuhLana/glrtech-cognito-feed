from transformers import pipeline

summarizer = pipeline("summarization", model="philschmid/bart-large-cnn-samsum")

def summary_generator(texto: str) -> str:
    tokens = len(texto.split())
    max_len = min(200, max(50, int(tokens * 0.8)))
    min_len = min(30, max(20, int(tokens * 0.4)))
    summary = summarizer(texto, max_length=max_len, min_length=min_len, do_sample=False)
    return summary[0]['summary_text']
