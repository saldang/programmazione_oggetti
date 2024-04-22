---
layout: post
title: Tracce d'esame
date: 2024-04-22
---

# Tracce d'esame 2024

{% for folder in folder.pages %}
{% if folder.dir contains 2024}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endfor %}
