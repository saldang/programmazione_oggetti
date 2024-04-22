---
layout: default
title: Tracce d'esame
---

# Tracce d'esame

{% for folder in site.pages %}
{% if folder.path contains '2024' %}

## 2024

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}

{% if folder.path contains '2023' %}

## 2023

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}

  {% endfor %}
