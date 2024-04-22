---
layout: default
title: Tracce d'esame
---

# Tracce d'esame

## 2024

{% for folder in site.pages %}
{% if folder.path contains '2024' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endfor %}
