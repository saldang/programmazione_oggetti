---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% for folder in site.pages %}
{{ folder.dir }}
{{ folder.name }}

{% if folder.dir contains slides %}
{% if folder.name != 'index.md' %}

- [{{folder.name}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endif %}
  {% endfor %}
